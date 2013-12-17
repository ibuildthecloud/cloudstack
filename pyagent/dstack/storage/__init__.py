class BaseStoragePool(object):
    def handle(self, req):
        name = req.name[len("storage."):].replace(".","_")
        if hasattr(self, name):
            getattr(self, name)(req = req, **req.data.__dict__)
        else:
            print "Unhandled method", name
            
